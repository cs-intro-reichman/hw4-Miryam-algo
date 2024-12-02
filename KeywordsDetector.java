public class KeywordsDetector {
    public static void main(String[] args) {
        String[] sentences = {
            "Our product will transform the market",
            "Programming is both painful and engaging",
            "This has nothing to do with machine learning",
            "We need to leverage our core competencies",
            "Let's talk about data and algorithms",
            "Chatbots are great but must be used carefully",
            "This blockchain-based solution will disrupt the industry",
            "The team showed great Synergy in the last project",
            "Use simple words without hype and fluff",
            "Our new technology presents a significant paradigm shift",
            "Effective presentations must be clear, concise, and humble"
        };
        // Some keywords that typically signal bullshit contents in business presentations 
        String[] keywords = {"synergy", "disrupt", "leverage", "Paradigm", "transform"};
        detectAndPrint(sentences, keywords);
    }

    // Iterates through all the sentences.
    // If a sentence contains one or more of the kewords, prints it.
    public static void detectAndPrint(String[] sentences, String[] keywords) {
        for (int i = 0; i < sentences.length; i++) {
            String sentence = sentences[i].toLowerCase();
            boolean found = false;  // Flag to check if any keyword is found in the sentence
    
            for (int j = 0; j < keywords.length; j++) {
                String word = keywords[j].toLowerCase();
    
                int sentenceIndex = sentence.indexOf(word.charAt(0));
    
                // While the word exists in the sentence, continue checking for a match
                while (sentenceIndex != -1) {
                    // Check if the rest of the characters in the word match the sentence
                    boolean matchWord = true;
                    if ((sentence.length() - sentenceIndex) >= word.length()) {
                        for (int k = 0; k < word.length(); k++) {
                            if (word.charAt(k) != sentence.charAt(sentenceIndex + k)) {
                                matchWord = false;
                                break;
                            }
                        }
                        if (matchWord) {
                            found = true;
                            break;
                        }
                    }
                    //finds the next occureance of the first character of the word
                    sentenceIndex = sentence.indexOf(word.charAt(0), sentenceIndex + 1); 
                }
            }

            if (found) {
                System.out.println(sentences[i]);
            }
        }
    }
}