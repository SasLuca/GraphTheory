package com.luca.graphtheory.assets;

/**
 * Created by Sas on 11/2/2015.
 */

import com.badlogic.gdx.files.FileHandle;

public class SaveFile
{

    //region Variables

    /*

        The filehandle object stores the path to our file
        We use this object to access the file

     */
    protected     FileHandle      fileHandle;

    /*

        The separator represents how the different values stored in the file are separated, be it a "\n" or " " etc...

    */
    protected     String          separator;

    //endregion

    //region Constructors

    public SaveFile(FileHandle fileHandle, String separator)
    {

        this.fileHandle           = fileHandle;

        this.separator            = separator;

    }

    public SaveFile(FileHandle fileHandle)
    {

        this.fileHandle           = fileHandle;

    }

    public SaveFile()
    {



    }

    //endregion

    //region Methods

    /*

        This method will return a single value from a file
        The variable element specifies which variable from the file to return based on the separator

    */
    public String readLine(int element)
    {

        /*

            This variable stores everything inside the file

        */
        String                    string;

        string                    = fileHandle.readString();

        /*

            We then put all the data from string into an array of strings

        */
        String[] text             = string.split(separator);

        /*

            Finally we return the specific element that was asked for from the array

        */
        return                    text[element];

    }

    public String readText()
    {

        String                    string;

        string                    = fileHandle.readString();

        /*

            This will return everything from the file in a single String object

        */
        return                    string;

    }


    public static String readText(FileHandle fileHandle)
    {

        String                    string;

        string                    = fileHandle.readString();

        return                    string;

    }

    public void writeLine(String string, boolean append)
    {

        /*

            Writes a String to the file, either by appending it or rewriting the file

         */
        fileHandle.               writeString(string, append);

    }

    public static void writeLine(FileHandle fileHandle, String string, boolean append)
    {

        fileHandle.               writeString(string, append);

    }

    //endregion

    //region Getters and Setters

    public void setFileHandle(FileHandle fileHandle)
    {

        this.fileHandle           = fileHandle;

    }

    public FileHandle getFileHandle()
    {

        return                    fileHandle;

    }

    public void setSeparator(String separator)
    {

        this.separator            = separator;

    }

    public String getSeparator()
    {

        return                    separator;

    }

    //endregion

}
