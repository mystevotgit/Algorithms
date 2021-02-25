import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandlingChallenge {
    private static final String FILE_NAME = "src/test/resources/fileToTarget.txt";
    private static final String TARGET_NAME = "src/main/resources/fileToTarget.txt";

    public static void main(String[] args) throws IOException {
        cleanUpFiles();
        Path sourcePath = Paths.get(FILE_NAME);
        Path targetPath = Paths.get(TARGET_NAME);
//        Files.copy(targetPath, sourcePath);
        File file = new File(FILE_NAME);
        file.delete();

//        String str = "This is a super story. \n";
//        FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME, true);
//        byte[] data = str.getBytes();
//        fileOutputStream.write(data);
//
//        InputStream inputStream = new FileInputStream(FILE_NAME);
//        StringBuilder stringBuilder = new StringBuilder();
//        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
//            String line;
//            while((line = bufferedReader.readLine()) != null) {
//                stringBuilder.append(line).append("\n");
//            }
//
//            System.out.println(stringBuilder);
//        }
//        finally {
//            if (inputStream != null) {
//                try {
//                    fileOutputStream.close();
//                    inputStream.close();
//                }catch(IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

//        cleanUpFiles();
    }

    public static void cleanUpFiles() {
        File targetFile = new File(FILE_NAME);
        targetFile.delete();
    }
}
