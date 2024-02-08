class TicketNumber
{
    private:
        int N;    
        int Number = 0;
    public:
    
    TicketNumber(int _N)
    {
        N =_N;
    }

    long GetSum()
    {
        long Sum = 0;
        int temp = Number;
        for(int i = 0; i < N; ++i)
        {
            temp %= 10*(i + 1);
            Sum += temp;
        }
        return Sum;
    }

    bool operator==(TicketNumber num)
    {
        return GetSum() == num.GetSum();
    }

    void operator++()
    {
        ++Number;
    }

}; 

long CountHappyTickets(int N)
{
    long Count = 0;
    TicketNumber Left(N), Right(N);
    for(int i = 0; i < N; ++i)
    {
        if (Left == Right) ++Count;
    }
    return Count;
}