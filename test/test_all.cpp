#include <gtest/gtest.h>
#include "tickets.h"
#include <iostream>
#include <string>
#include <fstream> 
/**
 * Google tests
 */
TEST(tickets, test_all) {
    std::string s = "";
    std::ifstream file;
    int in[10];
    long out[10];
    std::string path = "../test/1.Tickets/test.";
    for (size_t i = 0; i < 4; i++)
    {
        
        file.open(path + std::to_string(i) + ".in" );
        getline(file, s);
        in[i] = std::stoi(s);
        file.close();
        ASSERT_EQ(in[i],i+1) << s;
        s = "";
        file.open(path + std::to_string(i) + ".out" );
        getline(file, s);
        out[i] = std::stol(s);
        file.close();
        s = "";
        std::cout << "Count " << i + 1 << " = " << CountHappyTickets(in[i]) << std::endl;
        Ticket ticket(in[i]);
        ASSERT_EQ(ticket.GetSumHappyTikets(),out[i]);
    }

}

