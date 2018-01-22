package bw.practise.ang.util;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/*
	 * 
	 * @param urlString
	      被下载的文件地址
	   @param filename
	      本地文件名
	   @throws Exception
	      异常处理
	*/

public class download {
	public static void download(String urlString,String filename)throws Exception{
		//构造URL
		URL url=new URL(urlString);
		//打开连接
		URLConnection con=url.openConnection();
	    //输入流
		InputStream is=con.getInputStream();
		//1k的数据缓冲
		byte[] bs=new byte[1024];
		//读取到的数据长度
		int len;
		//输出的文件流
		FileOutputStream os=new FileOutputStream(filename);
		//开始读取
		while((len=is.read(bs))!=-1){
			os.write(bs,0,len);
		}
		os.close();
		is.close();
		
	}
	

}
