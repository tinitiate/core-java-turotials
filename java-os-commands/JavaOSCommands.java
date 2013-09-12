package JavaOSCommands;

import java.io.*;
/**
 * @author TINITIATE.COM
 *
 * > TOPIC : Java OSCommands, With Java.IO
 *
 * > NOTES : 1) Executing Operating System commands / Processes from Java
 *           2) Runtime Class allows the application to interface with
 *              the environment in which the application is running.
 *               - static getRuntime()
 *                     Returns the runtime object associated with the current Java application.
 *               - exec(String command)
 *                     Executes the specified string command in a separate process.
 *           3)  Process Class
 *                   This can be used to control and gather information from the process.
 *                   destroy()
 *                       Kills the subprocess.
 *                   exitValue()
 *                       Returns the exit value for the subprocess.
 *                   getErrorStream()
 *                       Returns the input stream connected to the error output of the subprocess.
 *                   getInputStream()
 *                       Returns the input stream connected to the normal output of the subprocess.
 *                   getOutputStream()
 *                       Returns the output stream connected to the normal input of the subprocess.
 *
 *
 */
public class JavaOSCommands
{
    public static void main(String[] args) throws java.io.IOException, java.lang.InterruptedException 
    {
        // Create a new Static getRuntime
        Runtime rtObj = Runtime.getRuntime();

        // Create a new OS process: UNIX command ls
        // Create a new OS process: WINDOWS "cmd /c <My Command>

        String windowsOS_Command = "dir c:\\windows";
        Process pObj = rtObj.exec("cmd /c " + " " +windowsOS_Command);

        // Get the process pObj's output: (Read from its InputStream)
        InputStream is = pObj.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        // And print each line
        String s = null;
        while ((s = reader.readLine()) != null)
        {
            System.out.println(s);
        }
        is.close();
        // Reading the exit code of the OS Process (OS Command)
        System.out.println("OS Process Exit Code:  " + pObj.exitValue());

        // Complete the process
        pObj.destroy();
    }
}
