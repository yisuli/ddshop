package com.lys.upload;

/**
 * User: Administrator
 * Date: 2017/11/16
 * Time: 19:31
 * Version:V1.0
 */
public class FtpUploadTest {
   /* @Test
    public void testFtpUpload() throws IOException {
        //创建FTPClient客户端
        FTPClient ftpClient = new FTPClient();
        //创建FTP连接
        ftpClient.connect("101.132.178.188",21);
        //登录
        ftpClient.login("ftpuser","ftpuser");
        //读取本地文件
        FileInputStream fileInputStream = new FileInputStream(new File("d:\\3.jpg"));
        //配置上传参数
        ftpClient.changeWorkingDirectory("/home/ftpuser/www/images");
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        //上传文件
        ftpClient.storeFile("hello.jpg",fileInputStream);
        //关闭连接
        fileInputStream.close();
        ftpClient.logout();

    }*/

    /*@Test
    public void testFtpUtil() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(new File("d:\\32.jpg"));
        FtpUtils.uploadFile("192.168.31.117",21,"ftpuser","dhc890dhc","/home/ftpuser/www/images","/2017/09/11","hello2.jpg",fileInputStream);
    }*/
}
