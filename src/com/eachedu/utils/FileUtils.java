package com.eachedu.utils;


import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import javax.activation.DataHandler;


public class FileUtils {

        /**
         * ��ȡ�ļ��б�
         * 
         * @param String
         *            fileDir ��ȡ�ļ���Ŀ¼
         * @return �ļ�����
         */
        public static File[] getFileList(String fileDir) {
                File dir = new File(fileDir);
                for (String children : dir.list()) {
                        System.out.println(children);
                }
                return dir.listFiles();
        }


        /**
         * ��ȡԴ�ļ��ַ�����
         * 
         * @param File
         *            file ��ȡ�ַ�������ļ�
         * @return �ַ�����
         */
        public static byte[] readFileByte(File file) {
                FileInputStream fis = null;
                FileChannel fc = null;
                byte[] data = null;
                try {
                        fis = new FileInputStream(file);
                        fc = fis.getChannel();
                        data = new byte[(int) (fc.size())];
                        fc.read(ByteBuffer.wrap(data));


                } catch (FileNotFoundException e) {
                        e.printStackTrace();
                } catch (IOException e) {
                        e.printStackTrace();
                } finally {
                        if (fc != null) {
                                try {
                                        fc.close();
                                } catch (IOException e) {


                                        e.printStackTrace();
                                }
                        }
                        if (fis != null) {
                                try {
                                        fis.close();
                                } catch (IOException e) {
                                        e.printStackTrace();
                                }
                        }


                }
                return data;
        }


        /**
         * ��ȡԴ�ļ��ַ�����
         * 
         * @param filename
         *            String �ļ�·��
         * @throws IOException
         * @return byte[] �ļ�����
         */
        public static byte[] readFileByte(String filename) throws IOException {


                if (filename == null || filename.equals("")) {
                        throw new NullPointerException("��Ч���ļ�·��");
                }
                File file = new File(filename);
                long len = file.length();
                byte[] bytes = new byte[(int) len];


                BufferedInputStream bufferedInputStream = new BufferedInputStream(
                                new FileInputStream(file));
                int r = bufferedInputStream.read(bytes);
                if (r != len)
                        throw new IOException("��ȡ�ļ�����ȷ");
                bufferedInputStream.close();


                return bytes;


        }


        /**
         * �ַ�����д���ļ�
         * 
         * @param byte[] bytes ��д����ַ�����
         * @param File
         *            file ��д����ļ�
         * @return �ַ�����
         */
        public static String writeByteFile(byte[] bytes, File file) {
                FileOutputStream fos = null;
                try {
                        fos = new FileOutputStream(file);
                        fos.write(bytes);
                } catch (FileNotFoundException e) {
                        e.printStackTrace();


                } catch (IOException e) {
                        e.printStackTrace();


                } finally {
                        if (fos != null) {
                                try {
                                        fos.close();
                                } catch (IOException e) {
                                        e.printStackTrace();
                                }
                        }
                }
                return "success";
        }


        /**
         * �ƶ�ָ���ļ����ڵ�ȫ���ļ�,(�����ƶ�)
         * 
         * @param fromDir
         *            Ҫ�ƶ����ļ�Ŀ¼
         * @param toDir
         *            Ŀ���ļ�Ŀ¼
         *@param errDir
         *            ����ļ�Ŀ¼
         * @throws Exception
         */
        public static void moveFile(String fromDir, String toDir, String errDir) {
                try {
                        // Ŀ���ļ�Ŀ¼
                        File destDir = new File(toDir);
                        if (!destDir.exists()) {
                                destDir.mkdirs();
                        }
                        // ��ʼ�ļ��ƶ�
                        for (File file : new File(fromDir).listFiles()) {
                                if (file.isDirectory()) {
                                        moveFile(file.getAbsolutePath(), toDir + File.separator
                                                        + file.getName(), errDir);
                                        file.delete();
                                        System.out.print("�ļ���" + file.getName() + "ɾ��ɹ�");
                                } else {
                                        File moveFile = new File(toDir + File.separator
                                                        + file.getName());
                                        if (moveFile.exists()) {
                                                moveFileToErrDir(moveFile, errDir);// ת�Ƶ�����Ŀ¼
                                        }
                                        file.renameTo(moveFile);
                                        System.out.print("�ļ�" + moveFile.getName() + "ת�Ƶ�����Ŀ¼�ɹ�");
                                }
                        }
                } catch (Exception e) {
                        e.printStackTrace();
                } finally {


                }
        }


        private static void moveFileToErrDir(File moveFile, String errDir) {
                int i = 0;
                String errFile = errDir + File.separator + "rnError"
                                + moveFile.getName();
                while (new File(errFile).exists()) {
                        i++;
                        errFile = errDir + File.separator + i + "rnError"
                                        + moveFile.getName();
                }
                moveFile.renameTo(new File(errFile));
        }


        /**
         * ���������ȡ�ֽ�����
         * 
         * @param
         */
        public static byte[] getFileByte(InputStream in) {
                ByteArrayOutputStream out = new ByteArrayOutputStream(4096);
                try {
                        copy(in, out);
                } catch (IOException e) {
                        e.printStackTrace();
                }
                return out.toByteArray();


        }


        /**
         * ����������������
         * 
         */
        private static void copy(InputStream in, OutputStream out)
                        throws IOException {


                try {
                        byte[] buffer = new byte[4096];
                        int nrOfBytes = -1;
                        while ((nrOfBytes = in.read(buffer)) != -1) {
                                out.write(buffer, 0, nrOfBytes);
                        }
                        out.flush();
                } catch (IOException e) {


                } finally {
                        try {
                                if (in != null) {
                                        in.close();
                                }
                        } catch (IOException ex) {
                        }
                        try {
                                if (out != null) {
                                        out.close();
                                }
                        } catch (IOException ex) {
                        }
                }


        }


        // DataHandlerд���ļ�
        public static boolean writeDataHandlerToFile(DataHandler attachinfo,String filename
                        ) {
                FileOutputStream fos = null;
                try {
                        fos = new FileOutputStream(filename);
                        writeInputStreamToFile(attachinfo.getInputStream(), fos);
                        fos.close();
                } catch (Exception e) {
                        return false;
                } finally {
                        if (fos != null) {
                                try {
                                        fos.close();
                                } catch (Exception e) {
                                }
                        }
                }
                return true;
        }

        
        /**
         *  递归删除文件或目录
         * @param dirPath
         */
        public static void delFileOrDir(String dirPath){
    		File fileOrDir = new File(dirPath);
    		
    		
    		if (fileOrDir.isDirectory()) {
    			
    			File[] subFiles = fileOrDir.listFiles();
    			
    			for (int i = 0; i < subFiles.length; i++) {
    				File subFile = subFiles[i];
    				//递归删除子目录或文件
    				delFileOrDir(subFile.getPath());
    				
    			}
    			//删除自己
    			fileOrDir.delete();
    			
    			
    			
    		}else{
    			System.out.println("######del file ..........."+fileOrDir.getPath());
    			fileOrDir.delete();
    			return;
    		}
    		 
    	}
        

        private static void writeInputStreamToFile(InputStream is, OutputStream os)
                        throws Exception {
                int n = 0;
                byte[] buffer = new byte[8192];
                while ((n = is.read(buffer)) > 0) {
                        os.write(buffer, 0, n);
                }
        }
}