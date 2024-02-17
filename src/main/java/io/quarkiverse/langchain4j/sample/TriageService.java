package io.quarkiverse.langchain4j.sample;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService
public interface TriageService {

    //    @SystemMessage("""
    //            You are working for a bank. You are an AI processing reviews about financial products. You need to triage the reviews into positive and negative ones.
    //            You will always answer with a JSON document, and only this JSON document.
    //            """)
    //    @SystemMessage("""
    //            You are helping developers and testers sorting issues in an issue tracker for a software project. You are an AI processing the description of the issue reports.
    //            You need to triage those and identify which ones are mainly about improving the project testsuite. That means for example issues about untested scenarios or about increasing test coverage or CI.
    //            Note, fixing a bug, which would normally entail also writing a test, does not mean the issue is about improving the testuite, as the main activity would be to fix the bug. A project testsuite improvement issue is
    //            something whose main focus is enhancing the existing tests or adding new ones, regardless of a reported software defect.
    //            You will always answer with a JSON document, and only this JSON document.
    //            """)
    @SystemMessage("""
            do you think a JIRA issue with a description as follows (delimited by ---) is about improving the corresponding project testsuite / testsuite coverage?
            You will always answer with a JSON document, and only this JSON document, containing:
                     - the 'evaluation' key set to 'POSITIVE' or 'NEGATIVE' depending on the answer to the question being yes or no
                     - the 'message' key set to a message with a brief high level categorization of the type of issue ("bug", "enhancement", "new feature", "test improvement", ...) and the reason why it was chosen.
             """)

    //    @UserMessage("""
    //            Your task is to process the description delimited by ---.
    //
    //             Answer with a JSON document containing:
    //            - the 'evaluation' key set to 'POSITIVE' if the issue description appears to be primarily focused on improving the project testsuite or testsuite coverage, 'NEGATIVE' otherwise
    //            - the 'message' key set to a message with a brief high level categorization of the type of issue ("bug", "enhancement", "new feature", "test improvement", ...) and the reason why it was chosen.
    //
    //            ---
    //            {review}
    //            ---
    //            """)
    @UserMessage("""
            ---
            {review}
            ---
            """)
    TriagedReview triage(String review);

}
