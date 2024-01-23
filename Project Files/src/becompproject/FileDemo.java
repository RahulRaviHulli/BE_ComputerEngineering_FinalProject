
package becompproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileDemo {
    
    public void copydir(File src, File dest) throws IOException
    {

        if (src.isDirectory())
        {

            // if dirctory not exists, create ite
            if (!dest.exists())
            {
                dest.mkdir();
                System.out.println("Directory copied from " + src + "  to "
                        + dest);
            }

            // list all the directory contents
            String files[] = src.list();

            for (String fileName : files)
            {
                // construct the src and dest file structure
                File srcFile = new File(src, fileName);
                File destFile = new File(dest, fileName);
                // recursive copy
                copydir(srcFile, destFile);
            }

        }
        else
        {
            // If file, then copy it
            fileCopy(src, dest);
        }
    }

    private void fileCopy(File src, File dest)
    throws FileNotFoundException, IOException
      {

        InputStream in = null;
        OutputStream out = null;

        try
        {
            // If file, then copy it
            in = new FileInputStream(src);
            out = new FileOutputStream(dest);

            byte[] buffer = new byte[1024];

            int length;
            // Copy the file content in bytes
            while ((length = in.read(buffer)) > 0)
            {
                out.write(buffer, 0, length);
            }

        }
        finally
        {
            if (in != null)
            {
                in.close();
            }
            if (out != null)
            {
                out.close();
            }
        }
        System.out.println("File copied from " + src + " to " + dest);
    }
    
}
