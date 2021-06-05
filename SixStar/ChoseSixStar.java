import java.util.Scanner;
import java.io.*;
import java.util.*;

public class ChoseSixStar
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Technique = 1, Heart = 2, Power = 3, Speed = 4, Mind = 5");
        System.out.print("Which attribute are you summoning for? ");
        int attribute = keyboard.nextInt();
        System.out.println();
        
        Scanner inputStream = null;
        int size = 0;
        switch(attribute)
        {
            case 1:
            try
            {
                inputStream = new Scanner(new FileInputStream("Technique.txt"));
            }
            catch(FileNotFoundException e)
            {
                System.out.println("File not found.");
                System.exit(0);
            }
            System.out.println("Technique");
            size = 28;
            break;
            
            case 2:
            try
            {
                inputStream = new Scanner(new FileInputStream("Heart.txt"));
            }
            catch(FileNotFoundException e)
            {
                System.out.println("File not found.");
                System.exit(0);
            }
            System.out.println("Heart");
            size = 29;
            break;
            
            case 3:
            try
            {
                inputStream = new Scanner(new FileInputStream("Power.txt"));
            }
            catch(FileNotFoundException e)
            {
                System.out.println("File not found.");
                System.exit(0);
            }
            System.out.println("Power");
            size = 24;
            break;
            
            case 4:
            try
            {
                inputStream = new Scanner(new FileInputStream("Speed.txt"));
            }
            catch(FileNotFoundException e)
            {
                System.out.println("File not found.");
                System.exit(0);
            }
            System.out.println("Speed");
            size = 28;
            break;
            
            case 5:
            try
            {
                inputStream = new Scanner(new FileInputStream("Mind.txt"));
            }
            catch(FileNotFoundException e)
            {
                System.out.println("File not found.");
                System.exit(0);
            }
            System.out.println("Mind");
            size = 31;
            break;
            
            default:
            System.out.println("Wrong number was inputted." + "\n" + "The program will now exit.");
            System.exit(0);
        }
        
        while(inputStream.hasNextLine())
        {
            String line = inputStream.nextLine();
            System.out.println(line);
        }
        System.out.println();
        
        boolean correct = true;
        int want = 0;
        while(correct)
        {
            System.out.print("How many characters do you want from your desired attribute? ");
            want = keyboard.nextInt();
            System.out.println();
            if(want > size)
            {
                System.out.println("The number inputted is more than the amount of characters." + "\n" + "Please answer the question again." + "\n");
            }
            else
            {
                correct = false;
            }
        }
        
        System.out.println("Enter the number(s) that correspond with that character(s)");
        int[] characters = new int[want];
        for(int x = 0; x < want; x++)
        {
            boolean dupe = false;
            while(dupe == false)
            {
                System.out.print("Character " + (x + 1) + ": ");
                characters[x] = keyboard.nextInt();
                int count = 0;
                if(x > 0)
                {
                    for(int y = 0; y < x; y++)
                    {
                        if(characters[x] == characters[y])
                        {
                            count++;
                        }
                    }
                
                    if(count == 0 && characters[x] < size)
                    {
                        dupe = true;
                    }
                    else
                    {
                        System.out.println("Number does not exist or Number is duplicated");
                        System.out.println("Please enter another number");
                    }
                }
                else
                {
                    dupe = true;
                }
            }
        }
        System.out.println();
        
        int again = 1;
        while(again == 1)
        {
            System.out.print("How many times do you want to summon? ");
            int test = keyboard.nextInt();
            System.out.println();
            
            int[] array = new int[5];
            double got = 0.0;
            for(int x = 0; x < test; x++)
            {
                System.out.println("Test " + (x + 1));
                for(int y = 0; y < 5; y++)
                {
                    if(y == 0)
                    {
                        array[y] = (int)(Math.random() * size + 1);
                    }
                    else
                    {
                        boolean dupe = true;
                        while(dupe == true)
                        {
                            int check = (int)(Math.random() * size + 1);
                            int count = 0;
                            for(int z = 0; z < y; z++)
                            {
                                if(array[z] == check)
                                {
                                    count++;
                                }
                            }
                            
                            if(count == 0)
                            {
                               array[y] = check;
                               dupe = false;
                            }
                        }
                    }
                    
                    String characterName = "";
                    String line = "";
                    switch(attribute)
                    {
                        case 1:
                        try
                        {
                            inputStream = new Scanner(new FileInputStream("Technique.txt"));
                        }
                        catch(FileNotFoundException e)
                        {
                            System.out.println("File not found.");
                            System.exit(0);
                        }
                        break;
            
                        case 2:
                        try
                        {
                            inputStream = new Scanner(new FileInputStream("Heart.txt"));
                        }
                        catch(FileNotFoundException e)
                        {
                            System.out.println("File not found.");
                            System.exit(0);
                        }
                        break;
                        
                        case 3:
                        try
                        {
                            inputStream = new Scanner(new FileInputStream("Power.txt"));
                        }
                        catch(FileNotFoundException e)
                        {
                            System.out.println("File not found.");
                            System.exit(0);
                        }
                        break;
                            
                        case 4:
                        try
                        {
                            inputStream = new Scanner(new FileInputStream("Speed.txt"));
                        }
                        catch(FileNotFoundException e)
                        {
                            System.out.println("File not found.");
                            System.exit(0);
                        }
                        break;
                            
                        case 5:
                        try
                        {
                            inputStream = new Scanner(new FileInputStream("Mind.txt"));
                        }
                        catch(FileNotFoundException e)
                        {
                            System.out.println("File not found.");
                            System.exit(0);
                        }
                        break;
                    } 
                    int done = 0;
                    while(inputStream.hasNextLine() && done == 0)
                    {
                        line = inputStream.nextLine();
                        if(line.contains(Integer.toString(array[y]) + ":"))
                        {
                            characterName = line.substring(line.indexOf(":") + 2,line.length());
                            done = 1;
                        }
                    }
                    System.out.println((y + 1) + ": " + array[y] + " (" + characterName + ")");
                }
            
                int yes = 0;
                for(int a = 0; a < want; a++)
                {
                    for(int b = 0; b < 5; b++)
                    {
                        if(characters[a] == array[b])
                        {
                            yes++;
                        }
                    }
                }
                if(yes != 0)
                {
                    got++;
                }
                total += yes;
                System.out.println("Amount of Characters wanted: " + yes + "\n");
            }
            System.out.println("Out of " + test + " runs, you got a desired character " + got/test * 100 + "% of the time");
            System.out.print("Do you want to run summons again? (yes = 1 / no = 2) ");
            again = keyboard.nextInt();
            System.out.println();
            if(again != 1)
            {
                System.out.print("Thank you for taking the time to use my program and I hope you have the best of luck in your summons!");
            }
        }
        keyboard.close();
        inputStream.close();
    }
}