package fileSearch;

import java.io.File;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

public class FileSearchUtil {
	
	 private static FileSearchUtil fileSearchUtil = new FileSearchUtil();
	 
	 private FileSearchUtil(){
		 
	 }
	 
	 public static FileSearchUtil getInstance(){
		 return fileSearchUtil;
	 }

	public String[] findAllFiles(String path) throws FileSearchException {
		List<String> files = new ArrayList<>();
		findAllFiles(files, path);
		return files.toArray(new String[] {});
	}

	private void findAllFiles(List<String> files, String path) throws FileSearchException {
		for (File file : new File(path).listFiles()) {
			if (true) {
				files.add(file.getAbsolutePath());
			}
			if (file.isDirectory()) {
				findAllFiles(files, file.getAbsolutePath());
			}
		}
	}

	public String[] findAllDirectories(String path) throws FileSearchException {
		List<String> files = new ArrayList<>();
		findAllDirectories(files, path);
		return files.toArray(new String[] {});
	}

	private void findAllDirectories(List<String> files, String path) throws FileSearchException {
		for (File file : new File(path).listFiles()) {
			if (file.isDirectory()) {
				files.add(file.getAbsolutePath());
			}
			if (file.isDirectory()) {
				findAllDirectories(files, file.getAbsolutePath());
			}
		}
	}

	public String[] findFilesByPattern(String path, String pattern) throws FileSearchException {
		List<String> files = new ArrayList<>();
		findFilesByPattern(files, path, pattern);
		return files.toArray(new String[] {});
	}

	private void findFilesByPattern(List<String> files, String path, String pattern) throws FileSearchException {
		for (File file : new File(path).listFiles()) {
			if (file.getName().matches(pattern)) {
				files.add(file.getAbsolutePath());
			}
			if (file.isDirectory()) {
				findFilesByPattern(files, file.getAbsolutePath(), pattern);
			}
		}
	}

	public String[] findFilesByLastChange(String path, Date date) throws FileSearchException {
		List<String> files = new ArrayList<>();
		findFilesByLastChange(files, path, date);
		return files.toArray(new String[] {});
	}

	private void findFilesByLastChange(List<String> files, String path, Date date) throws FileSearchException {
		for (File file : new File(path).listFiles()) {
			if (new Date(file.lastModified()).after(date)) {
				files.add(file.getAbsolutePath());

			}
			if (file.isDirectory()) {
				findFilesByLastChange(files, file.getAbsolutePath(), date);
			}
		}
	}

}
