# world-cup-scoreboard
A project to create a Scoreboard for World Cup Matches

Created by carneyd-olsztyn on 09/06/2023

The Original Task:

You are working in a sports data company, and we would like you to develop a new Live Football World Cup Scoreboard library that shows all the ongoing matches and their scores.

The scoreboard supports the following operations (I have added notes due to the questions that I have asked before):
1. Start a new match, assuming initial score 0 – 0 and adding it the scoreboard. This should capture following parameters:
	a. Home team
	b. Away team
		Note: Done on WorldCupScoreboard.startMatch, I have created a table for Team, which contains a long and short name for the teams (e.g. URU for Uruguay).
2. Update score. This should receive a pair of absolute scores: home team score and away team score.
		Note: I have discussed this requirement with Sam Gabor, I didn't like the updating of the home and away team scores as this could lead to more than one goal being scored at once. So I have cut off write access to the home, away and total score fields, these can now only be incremented in the home goal scored and away goal scored methods, where they only get incremented by one. I have created a separate class to hold the details of the goal (goalscorer, their number, home / away goal, half of the goal, and the time of it). I had originally methods and goal types for home/away disallowed goals, but I have taken them out due to time concerns and it not being required. We should be able to audit the match by adding up the updates on this table (MatchGoal) and matching with totalGoals; we can also do this for the home and away goals too.
3. Finish match currently in progress. This removes a match from the scoreboard.
		Note: Done on WorldCupScoreboard.finishMatch, I am adding to an archive of completed matches here as well, I had coded this before I had been told that it was unnecessary. But it could come in handy later (see below).
4. Get a summary of matches in progress ordered by their total score. The matches with the same total score will be returned ordered by the most recently started match in the scoreboard.
		Note: I have created a method WorldCupScoreboard.generateSummaryList, which will take a list of matches and order them as we do above. This can be used in conjunction with WorldCupScoreboard.printFullScoreboard or WorldCupScoreboard.printScoreboard to output the full scoreboard (with goalscorers) or the short scoreboard. At present I am using the short team names but that can easily be changed.


Design Choices:
 - In order to catch issues in how the matches are created I have created a MatchException class. Examples of the throwing of these exceptions are:
		- Starting the second half of a match a second time
		- Finishing a match during the first half
		- A first half goal is scored before the match starts, or a second half goal is scored before the second half begins
		- The match is not in progress.
		


Possibilities for Extension:
 - We haven't taken into account World Cup Groups here. There is no mention on the task. A group could be added to each team. We could then ensure that any match in the group stage was between two teams in that group, a MatchException could be thrown if that wasn't the case.
 - The list of completedMatches could be used to fill in group tables, as we have the relative scores (so we can assign points for victory/a draw, and also loot at goal difference / goals scored, and head to head record in case of a tie)
 - At the moment we only check for goals that they are scored after the first half starts or after the second half starts, ths could give rise to goals being scored extremely late. But we would need to think about this as we will not merely have 45 mins per half due to injury time.
 - Extend this to handle extra time and penalty shoot outs.