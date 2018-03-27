import com.atlassian.jira.issue.Issue;
import java.sql.Timestamp;
import java.lang.System;
int days=3;
long ms = System.currentTimeMillis();
Timestamp now = new Timestamp(ms);
Timestamp duedate = issue.getDueDate();

if((duedate && now.after(duedate)) || !duedate) {
   issue.dueDate = now + days;
}
