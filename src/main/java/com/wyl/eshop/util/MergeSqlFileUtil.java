package com.wyl.eshop.util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

/**
 * @Author :wyl
 * @Date :2019/8/7 16:37
 * @Version 1.0 :
 * @Description :
 */
public class MergeSqlFileUtil {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private final static String fileName = ".sql";

    /**
     * 获取当前路径下的所有文件中
     *
     * @time 2014年8月25日
     * @auther yuxu.feng
     * @param filepath
     * @return
     */
    private static List<File> getFiles(String filepath) {
        File file = new File(filepath);
        if (!file.exists() | file.listFiles(new MyFileFileter()) == null)
            return null;
        List<File> fileList = Arrays
                .asList(file.listFiles(new MyFileFileter()));
        // 最好在这里把 文件过滤掉 只获取文件夹
        return sortFolder(fileList);
    }

    /**
     * 按照文件夹按照文件名进行升序 或按着文件名的名字进行升序
     *
     * @time 2014年8月25日
     * @auther yuxu.feng
     * @param files
     * @return
     */
    private static List<File> sortFolder(List<File> files) {
        if (files.size() == 0)
            return null;
        Collections.sort(files, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                if (o1.isDirectory() && o2.isFile())
                    return -1;
                if (o1.isFile() && o2.isDirectory())
                    return 1;
                if (o1.isDirectory() && o2.isDirectory())
                    return sortFolderName(o1.getName(), o2.getName());
                else
                    return 0;
            }
        });
        return files;
    }

    /**
     * 根据文件夹名称排序
     *
     * @time 2014年8月25日
     * @auther yuxu.feng
     * @param startName
     * @param endName
     * @return
     */
    private static int sortFolderName(String startName, String endName) {
        if ((parseFloderName(startName) - parseFloderName(endName)) >= 0)
            return 1;
        else
            return -1;
    }

    /**
     * 将文件夹的名字(格式为 A.B.C.D) 转换为long型的数字
     *
     * @time 2014年8月25日
     * @auther yuxu.feng
     * @param floderName
     * @return
     */
    private static long parseFloderName(String floderName) {
        Scanner sc = new Scanner(floderName).useDelimiter("\\.");
        return (sc.nextLong() << 24) + (sc.nextLong() << 16)
                + (sc.nextLong() << 8) + (sc.nextLong());
    }

    /**
     * 使用NIO进行文件合并
     *
     * @time 2014年8月25日
     * @auther yuxu.feng
     * @param filepath
     */
    public static void mergerNIO(String filepath) {

        SimpleDateFormat fd = new SimpleDateFormat("yyyyMMddHHmmss");
        String nowTime = fd.format(new Date());
        List<File> fileList = getFiles(filepath);

        if (fileList == null)
            return;
        File fout = new File(filepath + File.separator + nowTime + fileName);

        try {
            @SuppressWarnings("resource")
            FileChannel mFileChannel = new FileOutputStream(fout).getChannel();
            FileChannel inFileChannel;
            List<File> files = null;

            for (File folder : fileList) {
                if (folder.isDirectory()) {
                    files = Arrays.asList(folder.listFiles());
                    // sortFolder(files);
                    for (File fin : files) {
                        // if (fin.getName().endsWith(fileName)) {
                        // inFileChannel = new FileInputStream(fin)
                        // .getChannel();
                        // inFileChannel.transferTo(0, inFileChannel.size(),
                        // mFileChannel);
                        //
                        // inFileChannel.close();
                        // }
                        if (fin.getName().endsWith(fileName)) {
                            inFileChannel = new FileInputStream(fin)
                                    .getChannel();
                            inFileChannel.transferTo(0, inFileChannel.size(),
                                    mFileChannel);

                            inFileChannel.close();

                            mFileChannel.write(ByteBuffer.wrap("\r\n"
                                    .getBytes()));

                        }
                    }
                }
            }
            mFileChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用普通IO进行拷贝文件
     *
     * @time 2014年8月27日
     * @auther yuxu.feng
     * @param filepath
     */
    public static void mergerIO(String filepath) {
        SimpleDateFormat fd = new SimpleDateFormat("yyyyMMddHHmmss");
        String nowTime = fd.format(new Date());
        List<File> fileList = getFiles(filepath);  //文件夹集合

        File fout = new File(filepath + File.separator + nowTime + fileName);
        BufferedInputStream inBuff = null;
        BufferedOutputStream outBuff = null;
        int i = 0;
        try {
            outBuff = new BufferedOutputStream(new FileOutputStream(fout));
            List<File> files = null;
            FileInputStream finput = null;
            if(null != fileList && fileList.size() > 0) {
                for (File folder : fileList) {
                    if (folder.isDirectory()) {
                        files = Arrays.asList(folder.listFiles());
                        for (File fin : files) {
                            finput = new FileInputStream(fin);
                            inBuff = new BufferedInputStream(finput);
                            byte[] b = new byte[finput.available()];
                            int len = -1;
                            while ((len = inBuff.read(b)) != -1) {
                                outBuff.write(b, 0, len);
                            }

                            inBuff.close();
                            outBuff.flush();

                        }
                    }
                }
                outBuff.close();
            }else {
                File file = new File(filepath);
                if(file.isDirectory()){
                    files = Arrays.asList(file.listFiles());
                    for (File fin : files) {
                        System.out.println("第"+i+"个执行");
                        finput = new FileInputStream(fin);
                        inBuff = new BufferedInputStream(finput);
                        byte[] b = new byte[2048];
                        int len = -1;
                        while ((len = inBuff.read(b,0,b.length)) != -1) {
                            String str = new String(b,0,len,"UTF-8");
                            System.out.println(str);
                            outBuff.write(b, 0, len);
                        }

                        inBuff.close();
                        outBuff.flush();

                    }
                    outBuff.close();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     *
     * @time 2014年8月27日
     * @auther yuxu.feng
     * @param filepath
     */
    public static void mergeByBuffWriter(String filepath) {

        SimpleDateFormat fd = new SimpleDateFormat("yyyyMMddHHmmss");
        String nowTime = fd.format(new Date());
        List<File> fileList = getFiles(filepath);

        if (fileList == null)
            return;

        try {
            File fout = new File(filepath + File.separator + nowTime + fileName);// 输出文件位置
            List<File> files = null;
            BufferedReader br = null;
            BufferedWriter bw = null;
            FileOutputStream fops = new FileOutputStream(fout);
            bw = new BufferedWriter(new OutputStreamWriter(
                    fops, "UTF-8"));
//            bw.write('\ufeff'); 带有bom格式的utf-8
//            fops.write(new byte[]{(byte)0xEF, (byte)0xBB, (byte)0xBF}); 带有bom格式的utf-8
            for (File folder : fileList) {
                if (folder.isDirectory()) {
                    files = Arrays.asList(folder.listFiles());
                    for (File fin : files) {
                        FileInputStream finput = new FileInputStream(fin);
                        br = new BufferedReader(new InputStreamReader(finput,
                                "UTF-8"));
                        char[] cbuf = new char[finput.available()];
                        int len = cbuf.length;
                        int off = 0;
                        int ret = 0;
                        while ((ret = br.read(cbuf, off, len)) > 0) {
                            off += ret;
                            len -= ret;
                        }

                        br.close();
                        bw.write(cbuf, 0, off);

                        bw.newLine();
                        bw.flush();
                    }
                }
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // /////////////////swing界面////////////////////////
//    private JLabel lblUsername;
//    private JTextField tfUsername;
//    private JButton btnOK;
//    private JButton btnExit;

//    public MergeSqlFileUtil() {
//        JPanel p1 = new JPanel();
//        p1.setLayout(new BorderLayout());
//        lblUsername = new JLabel("合并的文件目录:");
//        tfUsername = new JTextField(20);
//        p1.add(lblUsername, BorderLayout.WEST);
//        p1.add(tfUsername, BorderLayout.EAST);
//        JPanel p2 = new JPanel();
//        p2.setLayout(new BorderLayout());
//        JPanel p3 = new JPanel();
//        btnOK = new JButton("确定");
//        btnOK.addActionListener(this);
//        btnExit = new JButton("取消");
//        btnExit.addActionListener(this);
//        p3.add(btnOK);
//        p3.add(btnExit);
//        this.add(p1, BorderLayout.NORTH);
//        this.add(p2, BorderLayout.CENTER);
//        this.add(p3, BorderLayout.SOUTH);
//        this.setLocation(400, 300);
//        this.setSize(350, 110);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setVisible(true);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getActionCommand().equals("确定")) {
//            String path = tfUsername.getText();
//            Long endIo = System.currentTimeMillis();
//            MergeSqlFileUtil.mergerIO(path);
////            MergeSqlFileUtil.mergeByBuffWriter(path);
//            Long endNio = System.currentTimeMillis();
//
//            JOptionPane.showMessageDialog(this, "运行时间为:" + (endNio - endIo));
//        } else if (e.getActionCommand().equals("取消")) {
//            System.exit(0);
//        }
//    }

    public static void main(String[] args) throws Exception{
        MergeSqlFileUtil.joinFiles("C:\\Users\\Administrator\\Desktop\\test\\ecology9\\sqlupgrade\\DM","C:\\Users\\Administrator\\Desktop\\test\\out\\dm.sql","gb2312");
        MergeSqlFileUtil.joinFiles("C:\\Users\\Administrator\\Desktop\\test\\ecology9\\sqlupgrade\\Mysql","C:\\Users\\Administrator\\Desktop\\test\\out\\mysql.sql","gb2312");
        MergeSqlFileUtil.joinFiles("C:\\Users\\Administrator\\Desktop\\test\\ecology9\\sqlupgrade\\Oracle","C:\\Users\\Administrator\\Desktop\\test\\out\\orcale.sql","gb2312");
        MergeSqlFileUtil.joinFiles("C:\\Users\\Administrator\\Desktop\\test\\ecology9\\sqlupgrade\\SQLServer","C:\\Users\\Administrator\\Desktop\\test\\out\\sqlserver.sql","gb2312");
        MergeSqlFileUtil.joinFiles("C:\\Users\\Administrator\\Desktop\\test\\ecology9\\sqlupgrade\\ST","C:\\Users\\Administrator\\Desktop\\test\\out\\st.sql","gb2312");
    }

    public static void joinFiles(String path,String outFilePath,String code) throws IOException {
        File pathFile = new File(path);
        File outFile = new File(outFilePath);
        if(!outFile.exists()){
            outFile.createNewFile();
        }else{
            outFile.delete();
            outFile.createNewFile();
        }
        if(pathFile.isDirectory()){
            File[] fileList= pathFile.listFiles();
            int listLength =  fileList.length;
            for(int i=0;i<listLength;i++){
                System.out.println("fiiel lsist lengtH: " + listLength);
                File singleFile = fileList[i];
                //读取文件(字节流)
                InputStream in = new FileInputStream(singleFile);
                //写入相应的文件
                OutputStream out = new FileOutputStream(outFile,true);
                //读取数据
                //一次性取多少字节
                byte[] bytes = new byte[2048];
                //接受读取的内容(n就代表的相关数据，只不过是数字的形式)
                int n = -1;
                //循环取出数据
                while ((n = in.read(bytes,0,bytes.length)) != -1) {
                    //写入相关文件
                    out.write(bytes, 0, n);
                }
                out.write("\r\n".getBytes());
                //关闭流
                in.close();
                out.close();
            }


        }else{
            throw new RuntimeException("参数path不是目录");
        }
    }

}
