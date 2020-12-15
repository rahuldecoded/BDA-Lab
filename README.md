# BDA-Lab

- **Assignment1**: Word Count
- **Assignment2**: Word Search
- **Assignment3**: Stop Word Removal
- **Assignment4**: Weather Data Mining
- **Assignment5**: Store Data Mining

## The whole process is for Windows

## Prerequsits 
1. Install **Java** *1.8*
2. Install **Hadoop** *3.1.4*


## Steps to Run Map Reduce Assignments
1. Create a project eg. WSProgram
2. In the project (WSProgram) create a package (WSPackage)
3. Create (at least) 3 files for Driver, Mapper and Reducer
	- If needed create more class
4. Now you need to Add some external libraries, for that add the jar files in the **JAR Files** folder
5. Now it's time to export your project as jar file.
	- **Note:** while create the jar files you can mention the class that contains the main method if you \
	don't mention it then it's compulsory to mention the class name in the command life but if you do \
	mention it then you can skip writing the name of the java file in the command line.


## Steps to Run Pig Assignment

- Assignment 1
1. Create a folder named `Output` in the folder where you'll be having the script.
2. Run the script using, `pig -x local script_name.pig`
3. If the script run successfully then a folder will be generate in the `Output`

- Assignment 2
1. Need to rename the text files, make it Map Reduce compatiple and keep them the text files in a folder named `txt` and keep `txt`  in the folder where your pig scripts are.
2. Create a folder `Output` within the folder where you'll be having the scripts
3. First run the script.pig `pig -x local script.pig`
4. You can see inside `Output` there will be new 3 folders.
5. To run search.pig, use `pig -x local search.pig`


## Data
1. Weather Data Mining
	- [1901.txt](https://drive.google.com/file/d/1FvUFA2w1_wQN-DZ-Aw44INA4n_N__qM4/view?usp=sharing)
	- [1902.txt](https://drive.google.com/file/d/1OES03G8M9XU4G3DhPT0Cvald6giuWbc_/view?usp=sharing)
2. Store Data Mining
	- [purchase.txt](https://drive.google.com/file/d/1v_nJbyclaJt_5cdeBKFU423cdlfMQMEX/view?usp=sharing)