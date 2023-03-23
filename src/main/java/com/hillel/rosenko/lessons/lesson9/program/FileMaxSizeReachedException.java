package com.hillel.rosenko.lessons.lesson9.program;

public class FileMaxSizeReachedException extends Exception {
    private String message;
    private Long currentSize;
    private long maxSize;
    private String filePath;

    public FileMaxSizeReachedException(String message, Long currentSize, long maxSize, String filePath) {
        this.message = message;
        this.currentSize = currentSize;
        this.maxSize = maxSize;
        this.filePath = filePath;
    }

    public String getMessage() {
        return message;
    }

    @Override
	public String toString() {
		return "FileMaxSizeReachedException " + message + ", currentSize=" + currentSize + ", maxSize="
				+ maxSize + ", filePath=" + filePath + "]";
	}

	public Long getCurrentSize() {
        return currentSize;
    }

    public long getMaxSize() {
        return maxSize;
    }

    public String getFilePath() {
        return filePath;
    }
}