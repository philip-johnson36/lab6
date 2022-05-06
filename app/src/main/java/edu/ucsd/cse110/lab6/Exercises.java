package edu.ucsd.cse110.lab6;

import android.util.Log;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import edu.ucsd.cse110.lab6.misc.Constants;

@SuppressWarnings("unused")
public class Exercises {
    public static double mean(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return ((double)sum) / ((double)numbers.size());
    }

    public static double standardDeviation(List<Integer> numbers) {
        double mean = mean(numbers);

        double deviationSum = 0;
        for (int number : numbers) {
            deviationSum += Math.pow(mean - number, 2);
        }

        double length = numbers.size();
        double variance = deviationSum / length;
        return Math.sqrt(variance);
    }

    public static double exercise1(List<Integer> numbers) {
        return standardDeviation(numbers);
    }

    public static long exercise2(String input) {
        // This pattern matches the spaces between words, as well as punctuation and apostrophes.
        Pattern re = Pattern.compile("('|'s)?[.,;]?[\\s\\n]", Pattern.MULTILINE);
        //Stream<String> wordStream = re.splitAsStream(input);
        Set<String> excludedWords = Constants.excludedWords;
        long output = re.splitAsStream(input)
                .map(String::toLowerCase)
                .filter(word->!excludedWords.contains(word))
                .map(String::length)
                .filter(count->count==6)
                .reduce(0,(l1,l2)->l1+l2) / 6;
        return output;
    }
}


/*
my answers to the questions
Question #1
On the JGraphT website, identify the technical and user documentation pages. Include in your answer the URLs linking to both. Does the user documentation seem more like it uses a tutorial approach or a thematic approach? Why do you think so? (There is no wrong answer.)

technical : https://jgrapht.org/javadoc/
https://jgrapht.org/guide/UserOverview, thematic approach

Question #2
For each of the four approaches to documentation discussed above (tutorial, thematic, reference, and specification), characterize which applicable kind(s) of knowledge mentioned above (episteme or techne) you think they best convey or are best suited to.
Tutorial: techne
Thematic: episteme
Reference:techne
specification:episteme
Question #3
Find a documentation page online you have used in one of your other classes or a personal project that you found very useful or helpful. Which of the types of documentation discussed in this section best describes it?
https://minerl.readthedocs.io/en/latest/tutorials/first_agent.html
tutorial

 */