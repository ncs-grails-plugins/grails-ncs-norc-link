package edu.umn.ncs
import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(RecruitmentSegmentLink)
class RecruitmentSegmentLinkTests {

	def recruitmentSegment
	def intensityGroup

    protected void setUp() {
        super.setUp()

		intensityGroup = new IntensityGroup(name:'test group').save()

		recruitmentSegment = new RecruitmentSegment(
			intensityGroup: intensityGroup, 
			selectionCount: 1000,
			populationRatio: 1.0).save()
    }

    protected void tearDown() {
        super.tearDown()
    }


	void testConstraints() {

		def existingLink = new RecruitmentSegmentLink(
			westatSegmentFinalId:1042, 
			norcSegmentId:3, 
			primarySamplingUnitId:'20000048', 
			primarySamplingUnitName:'Ramsey County', 
			secondarySamplingUnitId:'1823.1', 
			secondarySamplingUnitName:'Greater East Side', 
			tertiarySamplingUnitId:'1823', 
			tertiarySamplingUnitName:'Highland Park', 
			segment: recruitmentSegment )
		mockForConstraintsTests(RecruitmentSegmentLink, [existingLink])

		def link = new RecruitmentSegmentLink()

		assert !link.validate()
		assert "nullable" == link.errors["westatSegmentFinalId"]
		assert "nullable" == link.errors["norcSegmentId"]
		assert "nullable" == link.errors["secondarySamplingUnitId"]
		assert "nullable" == link.errors["secondarySamplingUnitName"]
		assert "nullable" == link.errors["segment"]

		link = new RecruitmentSegmentLink(
			westatSegmentFinalId:1042,
			norcSegmentId:15, 
			primarySamplingUnitId:'156165615615', 
			primarySamplingUnitName:'',
			secondarySamplingUnitId:'', 
			secondarySamplingUnitName:'ffjadkfjldjfladjfldjflikjfldjfljdflijadlifjsdifjadfjdijflidjf;ljfdsijflijf;lsdjflaijfladijf;ladjf;dijflaidjf;laidjf;aidjf;aldijf',
			tertiarySamplingUnitId:'1835', 
			tertiarySamplingUnitName:'White Bear', 
			segment: recruitmentSegment)

		assert !link.validate()
		assert "unique" == link.errors["westatSegmentFinalId"]
		assert "range" == link.errors["norcSegmentId"]
		assert "maxSize" == link.errors["secondarySamplingUnitName"]
	}

}
