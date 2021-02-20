import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandlingChallenge {
    private static final String FILE_NAME = "src/test/resources/fileToCreate.txt";

    public static void main(String[] args) throws IOException {
//        cleanUpFiles();

//        File newFile = new File(FILE_NAME);
//        FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
//        System.out.println(newFile.createNewFile());

        InputStream inputStream = new FileInputStream(FILE_NAME);
        StringBuilder stringBuilder = new StringBuilder();
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }

            System.out.println(stringBuilder);
        }
        finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                }catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }

//        cleanUpFiles();
    }

    public static void cleanUpFiles() {
        File targetFile = new File(FILE_NAME);
        targetFile.delete();
    }
}
