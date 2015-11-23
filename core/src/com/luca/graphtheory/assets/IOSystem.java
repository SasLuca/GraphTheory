package com.luca.graphtheory.assets;

/**
 * Created by Sas on 11/2/2015.
 */

public class IOSystem
{

    /*

    *Example of SaveFile object. You use this object to write and read from files*

    private static      SaveFile    exampleFile = new SaveFile(args);

    */

    /*

        This class gets called at the beginning

    */
    public static void load()
    {

        /*

            *This is an example of how we read from a file and save the value we read to a variable

            ExampleClass.exampleVar = CastToExampleVarType(exampleFile.readLine[1]); //It is important to cast the value we read from String to the type of variable we want

            *or*

            for(int i = 0; i < example.HowManyVarsInFile; i++)
            {

                ExampleClass.exampleVar[i] = CastToExampleVarType(exampleFile.readLine[i]); //It is important to cast the value we read from String to the type of variable we want

            }

            *or*

            *If you want to be more efficient you can have separate methods for the variables you want to load

            loadExample1();

            *or*

            loadExample1();
            loadExample2();
            loadExample3();
            ...

         */

    }

    public static void save()
    {

        /*

            *Example of different methods of how to save. Remember to call this method each time something should be saved*

            exampleFile.writeLine("EXAMPLE", true) //File will become empty then "EXAMPLE" will be put at the beginning

            *or*

            exampleFile.writeLine("EXAMPLE", false) //"EXAMPLE" will be appended

            *or*

            for(int i = 0; i < ExampleClass.HowManyVarsWeWantToSave; i++)
            {

                if(i == 0)
                {

                    exampleFile.writeLine(CastToString(ExampleClass.exampleVar[0]), true)  //Remember to cast the values you want to save in a text file to String

                }
                else
                {

                    exampleFile.writeLine(CastToString(ExampleClass.exampleVar[i]), false) //Remember to cast the values you want to save in a text file to String

                }

            }

            *or*

            *If you want to be more efficient you can have separate methods for the variables you want to save

            saveExample1();

            *or*

            saveExample1();
            saveExample2();
            saveExample3();
            ...

        */

    }

    /*

        public void loadExample1()
        {

            SaveFile example1 = new SaveFile(args); // If you use this method, declare the files only when you need them inside the methods, this way they will be disposed of in the next GC event

            //load example 1

        }

        public void saveExample1()
        {

            SaveFile example1 = new SaveFile(args); // If you use this method, declare the files only when you need them inside the methods, this way they will be disposed of in the next GC event

            //save example 1

        }


    */

}
