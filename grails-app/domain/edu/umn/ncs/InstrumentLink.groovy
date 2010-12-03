package edu.umn.ncs

class InstrumentLink {
	// This is the instrument the IDs link to
	Instrument instrument
        String norcQuexId
        String norcDescription
	
	// this is the NORC DOC_ID
	String norcDocId

    static constraints = {
    }
}
