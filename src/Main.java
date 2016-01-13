
import java.io.File;
import java.util.Arrays;
import java.util.Date;

import fileSearch.FileSearchException;
import fileSearch.FileSearchUtil;

public class Main {

	public static void main(String[] args) throws FileSearchException {
		FileSearchUtil fileSearchUtil = FileSearchUtil.getInstance();
		File file = new File("C:/Users/P3502441/Downloads");
		//FileSearchUtil allFiles = new FileSearchUtil();
		String[] files;
		Date date = new Date(file.lastModified()- 3600);
		

		files = fileSearchUtil.findAllFiles("C:/Users/P3502441/workspace");

		//files = allFiles.findAllDirectories("C:/Users/P3502441/workspace");

		//files = allFiles.findFilesByPattern("C:\\Users\\P3502441\\workspace", ".*[.]java");

		//files = allFiles.findFilesByLastChange(file.getAbsolutePath(),date);

		System.out.println(Arrays.toString(files).replace(",", "\n"));
	}

}
