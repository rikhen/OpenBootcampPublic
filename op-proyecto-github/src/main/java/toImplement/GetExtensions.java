package toImplement;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class GetExtensions
{

    private static int fileCounter;
    private static LinkedList<String> Extensions;

    public static void main(String[] args)
    {
        fileCounter = 0;
        Extensions = new LinkedList<String>();
        Scanner read = new Scanner(System.in);

        System.out.print("Directory: ");
        String dirText = read.next();

        AddToFileList(dirText);

        java.util.Collections.sort(Extensions);
        int extCounter = Extensions.size();
        while(!Extensions.isEmpty())
        {
            System.out.println(Extensions.pop());
        }
        System.out.println("Total: " + extCounter + " extensions in " + fileCounter + " files.");



    }

    private static void AddToFileList(String dirText)
    {
        File dir = new File(dirText);
        if (dir.isFile())
        {
            String[] pieces = dirText.split("[.]");
            if(pieces.length>1)
            {
                String currentExtension = pieces[pieces.length-1].toLowerCase();
                if(!Extensions.contains(currentExtension))
                {
                    Extensions.add(currentExtension);
                }
            }
            fileCounter++;

        }
        else
        {
            String[] ToAdd = dir.list();
            for(int i=0;i<ToAdd.length;i++)
            {
                AddToFileList(dirText + "\\" + ToAdd[i]);
            }
        }

    }

}
