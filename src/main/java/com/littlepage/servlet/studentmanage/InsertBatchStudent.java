package com.littlepage.servlet.studentmanage;

import com.alibaba.excel.EasyExcel;
import com.littlepage.entity.Student;
import com.littlepage.listener.StudentListener;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * 批量插入学生
 */
@WebServlet(urlPatterns = "/manage/admin/insertBatch")
public class InsertBatchStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                // 上传文件存储目录
                String UPLOAD_DIRECTORY = "upload";
                // 上传配置
                int MEMORY_THRESHOLD = 1024 * 1024 * 3;  // 3MB
                int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
                int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
                // 检测是否为多媒体上传
                if (!ServletFileUpload.isMultipartContent(req)) {
                    // 如果不是则停止
                    PrintWriter writer = resp.getWriter();
                    writer.flush();
                    return;
                }
                // 配置上传参数
                DiskFileItemFactory factory = new DiskFileItemFactory();
                // 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
                factory.setSizeThreshold(MEMORY_THRESHOLD);
                // 设置临时存储目录
                factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
                ServletFileUpload upload = new ServletFileUpload(factory);
                // 设置最大文件上传值
                upload.setFileSizeMax(MAX_FILE_SIZE);
                // 设置最大请求值 (包含文件和表单数据)
                upload.setSizeMax(MAX_REQUEST_SIZE);
                // 中文处理
                upload.setHeaderEncoding("UTF-8");
                // 构造临时路径来存储上传的文件
                // 这个路径相对当前应用的目录
                String uploadPath = getServletContext().getRealPath("/") + UPLOAD_DIRECTORY;
                // 如果目录不存在则创建
                File uploadDir = new File(uploadPath);
                if (!uploadDir.exists()) {
                    uploadDir.mkdir();
                }
                try {
                    // 解析请求的内容提取文件数据
                    @SuppressWarnings("unchecked")
                    List<FileItem> formItems = upload.parseRequest(req);
                    if (formItems != null && formItems.size() > 0) {
                        // 迭代表单数据
                        for (FileItem item : formItems) {
                            // 处理不在表单中的字段
                            if (!item.isFormField()) {
                                String fileName = new File(item.getName()).getName();
                                String filePath = uploadPath + File.separator + fileName;
                                File storeFile = new File(filePath);
                                // 在控制台输出文件的上传路径
                                System.out.println(filePath);
//                                logger.info(filePath);
                                // 保存文件到硬盘
                                item.write(storeFile);
                                EasyExcel.read(storeFile, Student.class, new StudentListener()).sheet().doRead();
                                File delFile = new File(filePath);
                                delFile.delete();
                                req.getSession().setAttribute("message", "批量导入成功");
                            }
                        }
                    }
                } catch (Exception ex) {
                    req.getSession().setAttribute("message","Excel格式错误");
                }
                resp.sendRedirect("showstudents");
        }
        @Override
        protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            doGet(req, resp);
        }
}
