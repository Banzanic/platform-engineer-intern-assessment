# Platform Engineer Intern Assessment

## Assessment Description

You are working on an analytics system for a popular music streaming service. Your job is to create a program that records whenever a song is played, and keep track of the most played song by each artist. 

The program must support two different instructions: 

1. `record`, which records whenever a song by an artist is played.
2. `top`, which returns the most played song by a given artist.

The instructions will be received in a text file, where each line represents a different instruction. Each instruction must be processed in order, starting from the top. 

## Example Input

`input.txt`
```
record:Taylor Swift,Cruel Summer
record:Taylor Swift,Cruel Summer
record:Taylor Swift,Blank Space
record:Michael Jackson,Beat it
record:Taylor Swift,Cruel Summer
record:Taylor Swift,Blank Space
record:Michael Jackson,Beat it
record:Michael Jackson,Smooth Criminal
top:Taylor Swift
top:Michael Jackson
```

Each instruction follows the same format:

- First, the command to execute, either record or top followed by a colon.
- Second, the parameters for the command, enclosed in single quotes and separated by a comma.
  - For the record command, the first parameter is the artist’s name, and the second is the song name
  - For the top command, there is only one parameter, the artist’s name

## Example Output

The program output should be written to a file called `output.txt`.

For example, when the program executes the instructions in the example above, the only output should be:

`output.txt`
```
Taylor Swift: Cruel Summer
Michael Jackson: Beat it
```

The program returns Cruel Summer first as a response to the command `top:'Taylor Swift'` because that is the song that has been recorded the most times for that artist. The second output is Beat it in response to the command `top:'Michael Jackson'`. The record command does not have any output. 

## Assumptions

- Assume the parameters will never be null or empty, and will never be longer than 100 characters.
- Assume the artist name provided will always be unique.
- Assume the song name provided will always be unique per artist. This means song names are not unique globally; for example, the following input is valid:
  
```
record:Adele,Lovesong
record:The Cure,Lovesong
```

## Submission Instructions

1. Fork this repository into a public Github repository under your profile
2. Write a program that implements the `record` and `top` instructions and can process them from a plain text file as specified. You can use the programming language of your preference. 
   1. Write your solution in a **single** source code file under and commit it to the `src` directory. 
   2. Your solution file must not include any dependencies outside the standard library.
   3. Do not commit compiled files or dependency folders, e.g, `node_modules`.
3. An `input.txt` file is provided in the repository root directory as the input source for your program. Run your program with this input file. The program should **save the output** to a file called `output.txt` in the directory. Commit the `output.txt` file to the repository.
4. (**Extra Credit**) Include tests for your solution. Save the tests to a `tests` folder in the root of the repository.
5. <Email instructions>??

The submitted repository should have the following file structure (using python as a source code example):

```
├── README.md
├── input.txt
├── src
│   ├── main.py
├── tests
│   ├── tests.py #optional
├── output.txt
```

## Evaluation Criteria
Your code will be evaluated on the following areas:

- **Correctness**: does the code provide the right answer?
- **Readability**: how easy is it to understand what the code is doing?
- **Performance**: is the code using algorithms and data structures that have optimal performance (using [Big-O notation](https://en.wikipedia.org/wiki/Big_O_notation))? 


