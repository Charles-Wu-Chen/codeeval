 There are N unlocked rooms located in a row along the corridor.

A security guard, who starts the beat at the beginning of the corridor, passes by and closes the lock of every second door 
(2nd, 4th, 6th…). 
Then he returns to the beginning of the corridor, and passes by again changing the state of every third door 
(3rd, 6th, 9th…) to the opposite state — if the door is closed, security guard opens it; if the door is open, he closes it.

One iteration consists of two beats (when the security guard closes each second door, and changes the state of each third door to the opposite state). 
The iteration repeats M-1 times.

During the last iteration, the security guard just changes the state of the last door in a row (closes it, if the door is open or opens it, if the door is closed).

Your task is to determine how many doors have been left unlocked.

Input sample:

3 1
100 100

Your program accepts a filename as its first argument.

Each line of input contains 2 integers separated by space. The first integer represents number of doors (N), the second — number of iterations (M).

Output sample:

For each line of input print out how many doors are left unlocked: 

2
50

---

http://www.vipan.com/htdocs/bitwisehelp.html

1st beat in 1st iter (always close every 2nd)
000 | 010  > 010

2nd beat in 1st iter (change state of every 3rd)
010 ^(XOR)  001 > 011


Last iter
011 ^ 111 > 100


gate  > 1st beat mask
1 > 0	0	1  2**0
2 > 01	1	2	2**1
3 > 010	2	5	2**2+2**0
4> 0101	5	10	2**3+2**1
5> 01010	10	21	2**4+2**2 +2**0

2nd beat mast

1 	1
2	11
3	110
4	1101
5	11011
6	110110


Let`s try 10 10
0 0 0 0 0 0 0 0 0 0
1 step
0 1 0 1 0 1 0 1 0 1
0 1 1 1 0 0 0 1 1 1
2 step
0 1 1 1 0 1 0 1 1 1
0 1 0 1 0 0 0 1 0 1
3 step
0 1 0 1 0 1 0 1 0 1
0 1 1 1 0 0 0 1 1 1
4 step
0 1 1 1 0 1 0 1 1 1
0 1 0 1 0 0 0 1 0 1
5 step
0 1 0 1 0 1 0 1 0 1
0 1 1 1 0 0 0 1 1 1
6 step
0 1 1 1 0 1 0 1 1 1
0 1 0 1 0 0 0 1 0 1
7 step
0 1 0 1 0 1 0 1 0 1
0 1 1 1 0 0 0 1 1 1
8 step
0 1 1 1 0 1 0 1 1 1
0 1 0 1 0 0 0 1 0 1
9 step
0 1 0 1 0 1 0 1 0 1
0 1 1 1 0 0 0 1 1 1
10 step
0 1 1 1 0 0 0 1 1 0
