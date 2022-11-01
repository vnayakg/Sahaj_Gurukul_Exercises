# Exercise 6: Command Line Code Katas

#### Question 1: Find the top ten largest file in the root directory of your machine

**Soulution 1: using ``` du  ``` command**
- command: ``` ll | awk '{print $5, $9}' | sort -n -r -k 1,1 ```
- screenshot:
![screenshot_1](https://github.com/vinayak-gaikwad/Sahaj_Gurukul_Exercises/blob/main/exercise_6/screenshots/largest_using_sort.png)

**Soulution 2: using ``` sudo du -a | sort -n -r |head -n 10  ``` command**
- command: 
- screenshot:
![screenshot_2](https://github.com/vinayak-gaikwad/Sahaj_Gurukul_Exercises/blob/main/exercise_6/screenshots/largest_using_ll.png)

#### Question 2: Download log file and perform following

##### Question 2.1: Find all the session ids which expired because of 10000ms exceeded

**Soulution :**
- command: ``` grep "10000ms exceeded" Zookeeper_2k.log | awk '{print $9}' | uniq ```
- screenshot:
![screenshot_1](https://github.com/vinayak-gaikwad/Sahaj_Gurukul_Exercises/blob/main/exercise_6/screenshots/que_1_1.png)
![screenshot_1](https://github.com/vinayak-gaikwad/Sahaj_Gurukul_Exercises/blob/main/exercise_6/screenshots/que_1_2.png)


##### Question 2.2: IPs for all machines that are having trouble connecting to port 3888

**Soulution :**
- command: ``` grep -i ".*cannot.*3888$" Zookeeper_2k.log | awk -F " /"  '{print $2}' | awk -F ":" '{print $1}' | sort |  uniq ```
- screenshot:
![screenshot_1](https://github.com/vinayak-gaikwad/Sahaj_Gurukul_Exercises/blob/main/exercise_6/screenshots/que_2_1.png)
![screenshot_1](https://github.com/vinayak-gaikwad/Sahaj_Gurukul_Exercises/blob/main/exercise_6/screenshots/que_2_2.png)


##### Question 2.3: Create a list of files with names as the ip address and port number of all the IP addresses where the connection has been accepted from

**Soulution :**
- command: ``` awk -F " " '/Received connection/  {print $5, $10}' Zookeeper_2k.log | awk '{$1 = substr($1, 3, 16)} 1' | awk '{ group[$1] = (group[$1] == "" ? $2 : group[$1] OFS $2"\n" ) }END { for (group_name in group) print group_name,"\n\n" ,group[group_name],"\n\n" > group_name".txt" }'```
- screenshot:
![screenshot_1](https://github.com/vinayak-gaikwad/Sahaj_Gurukul_Exercises/blob/main/exercise_6/screenshots/que_3_1.png)
![screenshot_1](https://github.com/vinayak-gaikwad/Sahaj_Gurukul_Exercises/blob/main/exercise_6/screenshots/ques_3_2.png)
![screenshot_1](https://github.com/vinayak-gaikwad/Sahaj_Gurukul_Exercises/blob/main/exercise_6/screenshots/que_3_3.png)

[Reference: awk grouping on columns](https://unix.stackexchange.com/questions/506966/grouping-data-based-on-the-second-column)

##### Question 2.4: All connection broker ids in a file sorted in descending order

**Soulution :**
- command: ``` awk '{print $2}' Zookeeper_2k.log | awk -F "," '{print $2}' | sort -r | uniq > broker_ids.txt ```
- screenshot:
![screenshot_1](https://github.com/vinayak-gaikwad/Sahaj_Gurukul_Exercises/blob/main/exercise_6/screenshots/que_4_1.png)
![screenshot_1](https://github.com/vinayak-gaikwad/Sahaj_Gurukul_Exercises/blob/main/exercise_6/screenshots/ques_4_2.png)
