#include <iostream>
#include "tickets.h"

//#include "version.h"
/**
 * happy_tickets program OTUS algo hw 02
 */
int main(void)
{
    try {
        std::cout <<"1: " << CountHappyTickets(1) << std::endl;
        std::cout <<"2: " << CountHappyTickets(2) << std::endl;
        std::cout <<"3: " << CountHappyTickets(3) << std::endl;
    }
    catch(const std::exception &e)
    {
        std::cerr << e.what() << std::endl;
    }
    return 0;
}