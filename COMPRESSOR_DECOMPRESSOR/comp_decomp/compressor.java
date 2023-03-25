package comp_decomp;

import java.io.*;
import java.util.zip.GZIPOutputStream;


public class compressor {
    public static void method(File file) throws IOException{
        String fileDirectory=file.getParent();

        //fis helps to read the data
        FileInputStream fis=new FileInputStream(file);

        FileOutputStream fos=new FileOutputStream(fileDirectory+"/CompressedFile.gz");

        //final output file is gzip where we gonna write the compressed data
        GZIPOutputStream gzip=new GZIPOutputStream(fos);


        byte buffer[]=new byte[1024];
        int len;

        //fis file being read inside the buffer array
        //-1 indicates EOF reached
        while((len=fis.read(buffer))!=-1){
            gzip.write(buffer,0,len);
        }

        gzip.close();
        fos.close();
        fis.close();



    }

    public static void main(String args[]) throws IOException{
        File path=new File("/Users/Kislay/Downloads/Compressor/compressordecompressor/Testfile\"");
        method(path);
    }
}
