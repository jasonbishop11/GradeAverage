package com.company;

/***
Consider a grading scheme where your final grade is computed more generously
if your grades show improvement over the term.  Scores show improvement
if each grade is greater than or equal to the previous grade.

A student has x scores indexed from 0 to x-1.  If the scores have shown improvement
only those grades with indexes greater than to equal to x/2 are averaged.  If the
scores have not improved, all of the scores are averaged.
***/

public class GradeAverage {

	private int [] scores;
	
	public GradeAverage(int [] s)
	{
		scores = s;
	}
	// returns the mean (average) of the values in the scores array
	// whose indexes are between first and last (including first and last).  
	//You may assume that first and last are > 0 and < scores.length
	private double mean(int first, int last)
	{
		double total  = 0;
		for(int i = first; i<=last; i++){
			total+=(double)scores[i];
		}
		return total/(last-first+1);
	}
	
	// returns true if each successive value in scores is greater than
	// or equal to the previous value.  Otherwise returns false
	private boolean showsImprovement()
	{
		boolean anyLower = true;
		for(int i = 1; i<=scores.length-1; i++){
			if(scores[i-1]>scores[i]){
				return false;
			}
		}
		return anyLower;
	}
	
	// if the values in the scores array show improvement, returns the
	// average of the elements in scores with indexes greater than or
	// equal to scores.length()/2
	public double finalGrade()
	{
		if(this.showsImprovement()){
			return this.mean(scores.length/2, scores.length-1);
		}else{
			return this.mean(0, scores.length-1);
		}
	}
	public static void main(String[] args) {
		int [] s1 = {50,50,20,80,53};   // not improved, finalGrade is 50.6
		int [] s2 = {20,50,50,53,80};   // improved, final grade is 61.0
		int [] s3 = {20,50,50,80};      // improved, final grade is 65.0

		GradeAverage sr1 = new GradeAverage(s1);
		System.out.println("Mean: " + sr1.mean(0,4));
		System.out.println("Improved?: " + sr1.showsImprovement());
		System.out.println("Final: " + sr1.finalGrade());
		GradeAverage sr2 = new GradeAverage(s2);
		System.out.println("Mean: " + sr2.mean(1,4));
		System.out.println("Improved?: " + sr2.showsImprovement());
		System.out.println("Final: " + sr2.finalGrade());
		GradeAverage sr3 = new GradeAverage(s3);
		System.out.println("Mean: " + sr3.mean(2,3));
		System.out.println("Improved?: " + sr3.showsImprovement());
		System.out.println("Final: " + sr3.finalGrade());
	}

}
/*
Output:
Mean: 50.6
Improved?: false
Final: 50.6
Mean: 58.25
Improved?: true
Final: 61.0
Mean: 65.0
Improved?: true
Final: 65.0
 */
