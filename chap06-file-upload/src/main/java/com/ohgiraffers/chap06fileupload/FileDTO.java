package com.ohgiraffers.chap06fileupload;

public class FileDTO {
    private String originFileName; // 원본 이름을 데이터베이스에 저장 -> 사용자에게 보여줄 때 이 이름으로 다시 바꿔서 보여주고
    private String saveName; // 이름을 변경해서 DB에 저장함 해킹이나 다른 사용자와 겹치기 등의 문제
    private String filePath; // 저장 경로
    private String fileDescription; // 설명

    public FileDTO() {
    }

    public FileDTO(String originFileName, String saveName, String filePath, String fileDescription) {
        this.originFileName = originFileName;
        this.saveName = saveName;
        this.filePath = filePath;
        this.fileDescription = fileDescription;
    }

    public String getOriginFileName() {
        return originFileName;
    }

    public void setOriginFileName(String originFileName) {
        this.originFileName = originFileName;
    }

    public String getSaveName() {
        return saveName;
    }

    public void setSaveName(String saveName) {
        this.saveName = saveName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileDescription() {
        return fileDescription;
    }

    public void setFileDescription(String fileDescription) {
        this.fileDescription = fileDescription;
    }

    @Override
    public String toString() {
        return "FileDTO{" +
                "originFileName='" + originFileName + '\'' +
                ", saveName='" + saveName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", fileDescription='" + fileDescription + '\'' +
                '}';
    }
}
