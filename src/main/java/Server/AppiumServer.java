package Server;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;

import java.io.IOException;
import java.net.ServerSocket;

public class AppiumServer
{
    public boolean checkIfServerIsRunning(int port)
    {
        boolean is_server_running = false;

        ServerSocket server_socket;
        try
        {
            server_socket = new ServerSocket(port);
            server_socket.close();
        }
        catch (IOException e)
        {
            is_server_running = true;
        }
        finally
        {
            server_socket = null;
        }
        return is_server_running;
    }

    public void startServer()
    {
        CommandLine cmd = new CommandLine("C:\\Program Files\\nodejs\\node.exe");
        //cmd.addArgument("C:\\Program Files\\nodejs\\node_modules\\appium\\lib\\main.js");
        cmd.addArgument("C:\\Program Files\\nodejs\\node_modules\\appium\\build\\lib\\main.js");
        cmd.addArgument("--address");
        cmd.addArgument("127.0.0.1");
        cmd.addArgument("--port");
        cmd.addArgument("4723");

        DefaultExecuteResultHandler handler = new DefaultExecuteResultHandler();
        DefaultExecutor executor = new DefaultExecutor();
        executor.setExitValue(1);
        try
        {
            executor.execute(cmd, handler);
            Thread.sleep(10000);
        }
        catch (IOException | InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public void stopServer()
    {
        Runtime runtime = Runtime.getRuntime();
        try
        {
            runtime.exec("taskkill /F /IM node.exe");
        }
        catch
        (IOException e)
        {
            e.printStackTrace();
        }

    }
}
