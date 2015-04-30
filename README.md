# DFA_in_Java
An exercise in creating a program (java) which reads a DFA from a txt file, gets a 
user input string, and outputs if the DFA accepts or rejects this string.  

Encoding a DFA - design a method for representing a DFA as a text file.

The text file for the DFA has 6 parts. The first part is a description of the types 
of strings the DFA is accepts. On the next line is the total number of states, then
the DFA’s alphabet. I have a field for the start state, although all of my sample 
DFA files start on state 0. The accept states are numbers which correspond with a 
state’s position. Finally the transitions have the state, and the next state based 
on a 0 input, and the next state based on a 1 input. The transition function is based
on a transition table as described in the book.

Example: 
description	This DFA accepts strings ending in 1.
qty of states	  2
alphabet	      01
start state	    0
accept state	  1,#
transition from state 0  	  0,0,1
transitions from state 1	  1,0,1

