package algorithmCode.InterestingCode;

import java.io.File;

/**
 * 描述：查询文件
 * 找出某个文件下的所有.jar
 * 
 * @author BrokenColor
 * @date 2019年4月1日
 */
public class FilesFind {

	public static void main(String[] args) {
		File files = new File("D:\\code");
		FilesFind find = new FilesFind();
		find.method(files);
	}
	 public void method(File file) {
		 File[] files = file.listFiles();
		 for (File file2 : files) {
			 if (file2.isDirectory()) {
				 method(file2);
			}else if(file2.getName().endsWith(".jar")){
//				System.out.println(file2.getName());
				System.out.println(file2.getPath());
			}
		}
	 }

}
