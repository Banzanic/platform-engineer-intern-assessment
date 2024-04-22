# Platform Engineer Intern Assessment

This is the assessment for the Platform Engineer Intern (Delivery) role at SpotOn. **Read these instructions completely** before starting solving the problem. If you have any questions, feel free to email us at the address provided by your recruiter.

## Assessment Description

You are working on an analytics system for a popular music streaming service. Your job is to create a program that records whenever a song is played, and keep track of the most played song by each artist. 

The program must support two different instructions: 

1. `record`, which records whenever a song by an artist is played.
2. `top`, which returns the most played song by a given artist.

The instructions will be received in a text file, where each line represents a different instruction. Each instruction must be processed in order, starting from the top. 

### Example Input

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

- First, the command to execute, either `record` or `top` followed by a colon.
- Second, the parameters for the command, separated by a comma.
  - For the `record` command, the first parameter is the artist’s name, and the second is the song name
  - For the `top` command, there is only one parameter, the artist’s name

### Example Output

The program should produce output in response to the `top` command only. The `record` command should not produce any output. 
The output to the top command should be the requested artist name, followed by a colon, and the song that has been played the most times by that artist.
The program output should be written to a file called `output.txt`.

For example, when the program executes the instructions in the `input.txt` example above, the only output should be:

`output.txt`
```
Taylor Swift:Cruel Summer
Michael Jackson:Beat it
```

The first line is the output to the command `top:Taylor Swift` because `Cruel Summer` is the song that has been recorded the most times for that artist. The second line is in response to the command `top:Michael Jackson`.

### Assumptions

- Assume the artist name and song name parameters will never be null or empty, and will never be longer than 100 characters.
- Assume the artist name provided will always be unique.
- Assume the song name provided will always be unique per artist. This means song names are not unique globally; for example, the following input is valid:
  
```
record:Adele,Lovesong
record:The Cure,Lovesong
```

## Submission Instructions

1. Fork this repository into a public Github repository under your profile.
2. Write a program that implements the `record` and `top` instructions and can process them from a plain text file as specified. You can use the programming language of your preference. 
   1. Write your solution in a **single** source code file and commit it to the `src` directory. 
      1. Your solution file must not include any dependencies outside the standard library.
      2. Do not commit compiled files or dependency folders, e.g, `node_modules`.
3. An `input.txt` file is provided in the repository root directory as the input source for your program. Run your program with this input file. **Do not modify this file** under any circumstances.
4. The program should save the output to a file called `output.txt` in the directory. **Commit** the `output.txt` file to the repository.
5. **Extra Credit #1** Include tests for your solution. Save the tests to a `tests` folder in the root of the repository.
6. **Extra Credit #2** Containerize the program. Include a `Dockerfile` in the root of the repository that allows us to execute your program by using the `docker run` command. 
7. Email the link to your repository to your recruiter and the team to the email address provided to you.


The submitted repository should have the following file structure (using python as a source code example):

```
├── README.md
├── input.txt
├── src
│   ├── main.py
├── tests
│   ├── tests.py #optional
├── Dockerfile #optional
├── output.txt
```

## Evaluation Criteria
Your code will be evaluated on the following areas:

- **Correctness**: does the code provide the right answer?
- **Readability**: how easy is it to understand what the code is doing?
- **Performance**: is the code using algorithms and data structures that have optimal performance (as measured using [Big-O notation](https://en.wikipedia.org/wiki/Big_O_notation))? 

Be prepared to discuss your code and design decisions with the team in a follow up interview. We expect you to know the Big-O runtime complexity of your implementation of `record` and `top`.


