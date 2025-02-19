// private class BrutTickets
// {
//     private int N;

//     public BrutTickets(int _N)
//     {
//         N = _N;
//     }

//     long GetSumNumber(long Number)
//     {
//         long Sum = 0;
//         for (int i = N; i >= 0; i--) {
//             Sum += Number % 10;
//             Number /= 10;
//         }
//         return Sum;
//     }

//     long GetHappyCount()
//     {
//         long Count = 0;
//         long MaxNum = (long)Math.pow(10,N);
//         for(long left = 0; left < MaxNum; left++)
//             for(long right = 0; right < MaxNum; right++)
//                 if(GetSumNumber(left) == GetSumNumber(right)) Count++;
//     return Count;

//     }
// }; 

/// @brief Happy tickets count Fast algoritm

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalTime;

public class tickets
{
    private int N;
    private int SumsNumber;
    private long SumsArray[];
    public tickets(int _N)
    {
        N = _N;
        SumsNumber = N*9 + 1;
        SumsArray = new long[SumsNumber];
        for (int i = 0; i < SumsNumber; i++)
            SumsArray[i] = 0;
    }


    int GetSumNumber(long Number)
    {
        int Sum = 0;
            for (int i = N; i >= 0; i--) {
                Sum += Number % 10;
                Number /= 10;
            }
        return Sum;
    }

    long GetFastHappyCount()
    {
        long Count = 0;
        long MaxNumber = (long) Math.pow(10,N);
        for (long Number = 0; Number < MaxNumber; Number++)
            SumsArray[GetSumNumber(Number)]++;

        for (int i = 0; i < SumsNumber; i++)
            Count += SumsArray[i] * SumsArray[i];
    
        return Count;
    }

 
    public static void main(String[] args) throws NumberFormatException, IOException
    {
        System.out.println("Java test");
        long start = System.currentTimeMillis();

        for(int i = 0; i < 10; i++)
        {

            int in = 0;
            long out = 0;
            long cout = 0;
            String path ="1.Tickets/test.";
            BufferedReader reader_in = new BufferedReader(new FileReader(path + i + ".in"));
            in = Integer.parseInt(reader_in.readLine());
            reader_in.close();
            BufferedReader reader_out = new BufferedReader(new FileReader(path + i + ".out"));
            out = Long.parseLong(reader_out.readLine());
            reader_out.close();
            tickets ticket = new tickets(in);
            cout = ticket.GetFastHappyCount();
            assert out == cout;
            System.err.print("java fast count: " + in + " " + cout + "...");
            if (out == cout) System.err.println("Pass");
            else System.err.println("Fail");
        }
        long end = System.currentTimeMillis();
        double duration_sec = (double)(end - start) / 1000;
        System.out.print("Time: ");
        System.out.print(duration_sec);
        System.out.println(" sec");
    }
            
};