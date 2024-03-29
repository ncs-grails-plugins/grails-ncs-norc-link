package edu.umn.ncs

/** 
This class represents the link to norc data for segments 
 */
class RecruitmentSegmentLink {

	/** Westat's unique segment ids */
	Integer westatSegmentFinalId
	/** NORC's unique segment ids  */
	Integer norcSegmentId
	/** Study's primary sampling unit id, which is the same accross all segments */
	String primarySamplingUnitId = '20000048'
	/** Study's primary sampling unit name, which is the same accross all segments  */
	String primarySamplingUnitName = 'Ramsey County'
	/** Study's secondary smapling unit id, which is unique per segment  */
	String secondarySamplingUnitId
	/** Study's secondary sampling unit name, which is unique per segment  */
	String secondarySamplingUnitName
	/** Study's tertiary sampling unit id, which is unique and pertains only to the 12 HIGH segments  */
	String tertiarySamplingUnitId
	/** Study's tertiary sampling unit name, which is unique and pertains only to the 12 HIGH segments  */
	String tertiarySamplingUnitName
	/** Health Studies' Segment ids, ranging from 1-36  */
	RecruitmentSegment segment

	/** Non-default constraints for this class  
	<dl>
		<dt>westatSegmentFinalId</dt>
			<dd>Is unique</dd>
		<dt>norcSegmentId</dt>
			<dd>Ids range from 1 to 12</dd>
		<dt>primarySamplingUnitId</dt>
			<dd>Id equals 20000048</dd>
		<dt>primarySamplingUnitName</dt>
			<dd>Name is 'Ramsey County'</dd>
		<dt>secondarySamplingUnitId</dt>
			<dd>Is unique and cannot be blank</dd>
		<dt>secondarySamplingUnitName</dt>
			<dd>Cannot be blank, string length maximum size is 60 characters</dd>
		<dt>tertiarySamplingUnitId</dt>
			<dd>Can be blank</dd>
		<dt>tertiarySamplingUnitName</dt>
			<dd>Can be blank, and string length maximum size is 60 characters</dd>
	</dl>
	*/
	static constraints = {
		westatSegmentFinalId(unique:true)
		norcSegmentId(range:1..12)
		primarySamplingUnitId(maxSize:32)
		primarySamplingUnitName()
		secondarySamplingUnitId(unique:true, maxSize:32)
		secondarySamplingUnitName(maxSize:60)
		tertiarySamplingUnitId(nullable:true, maxSize:32)
		tertiarySamplingUnitName(nullable:true, maxSize:60)
		segment()
    }
}
