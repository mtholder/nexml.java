package org.biophylo.Matrices.Datatype;

/*
'A' => [A---],
'C' => [-C--],
'G' => [--G-],
'T' => [---T],
'M' => [AC--],
'R' => [A-G-],
'W' => [A--T],
'S' => [-CG-],
'Y' => [-C-T],
'K' => [--GT],
'V' => [ACG-],
'H' => [AC-T],
'D' => [A-GT],
'B' => [-CGT],
'X' => [ACGT],
'N' => [ACGT],
*/

public class Dna extends Datatype {
	private static int[][] dnalookup = { 
		{1,0,0,0,},
		{0,1,0,0,},
		{0,0,1,0,},
		{0,0,0,1,},
		{1,1,0,0,},
		{1,0,1,0,},
		{1,0,0,1,},
		{0,1,1,0,},
		{0,1,0,1,},
		{0,0,1,1,},
		{1,1,1,0,},
		{1,1,0,1,},
		{1,0,1,1,},
		{0,1,1,1,},
		{1,1,1,1,},
		{1,1,1,1,},
	};	
	
	public Dna() {
		this.alphabet = "ACGTMRWSYKVHDBXN";
		this.missing = '?';
		this.gap = '-';
		this.lookup = dnalookup;
	}
	
}
