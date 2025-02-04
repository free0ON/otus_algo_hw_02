#include <math.h>
#include <iostream>
/// @brief 
class Ticket
{
    private:
    int N;
    public:
    
    Ticket(int _N)
    {
        N = _N;
    }

    long GetSumHappyTikets()
    {
        long Count = 0;
        long max_num = pow(10,N);
        for(long left = 0; left < max_num; left++)
            for(long right = 0; right < max_num; right++)
                if(GetSumTiketPart(left) == GetSumTiketPart(right)) Count++;
    return Count;

    }

    long GetSumTiketPart(long TicketPart)
    {
        long Sum = 0;
        for (int i = N; i >= 0; i--) {
            Sum += TicketPart % 10;
            TicketPart /= 10;
        }
        return Sum;
    }

}; 

long SumTicket(long TicketPart, int num)
{
    long Sum = 0;
    for (int i = num; i >= 0; i--) {
        Sum += TicketPart % 10;
        TicketPart /= 10;
    }
    return Sum;
}

long CountHappyTickets(int num)
{
    long Count = 0;
    long max_num = pow(10,num);

    for(long left = 0; left < max_num; left++)
        for(long right = 0; right < max_num; right++)
            if(SumTicket(left,num) == SumTicket(right,num)) Count++;
    return Count;
}
