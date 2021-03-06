package biolockj.module.report.taxa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TaxaLevelTable extends HashMap<String, HashMap<String, Double>>{

	private String level;
	public String getLevel() { return level;}
	public TaxaLevelTable(String level){
		this.level = level;
	}
	
	public HashMap<String, Double> newSampleRow(String sampleID){
		HashMap<String, Double> newRow = new HashMap<>();
		this.put(sampleID, newRow);
		return newRow ;
	}
	
	public List<String> listTaxa (){
		Set<String> bigSet = new TreeSet<>();
		for (String sample : this.keySet() ) {
			bigSet.addAll( this.get( sample ).keySet() );
		}
		List<String> allTaxa = new ArrayList<>();
		allTaxa.addAll( bigSet );
		Collections.sort(allTaxa);
		return allTaxa;
	}
	
	public List<String> listSamples (){
		final List<String> allSampleIDs = new ArrayList<>();
		allSampleIDs.addAll( this.keySet() );
		Collections.sort(allSampleIDs);
		return allSampleIDs;
	}
	
	private static final long serialVersionUID = 3873959114273802005L;
}
