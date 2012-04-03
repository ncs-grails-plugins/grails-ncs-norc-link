package edu.umn.ncs
import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(RecruitmentSegmentLink)
class RecruitmentSegmentLinkTests {

    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testSomething() {

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
			segmentId:10 
		)
		mockForConstraintsTests(RecruitmentSegmentLink, [existingLink])

		def link = new RecruitmentSegmentLink()

		assert !link.validate()
		assert "nullable" == link.errors["westatSegmentFinalId"]
		assert "nullable" == link.errors["norcSegmentId"]
		assert "nullable" == link.errors["primarySamplingUnitId"]
		assert "nullable" == link.errors["primarySamplingUnitName"]
		assert "nullable" == link.errors["secondarySamplingUnitId"]
		assert "nullable" == link.errors["secondarySamplingUnitName"]
		assert "nullable" == link.errors["tertiarySamplingUnitId"]
		assert "nullable" == link.errors["tertiarySamplingUnitName"]
		assert "nullable" == link.errors["segmentId"]

		link = new RecruitmentSegmentLink(
			westatSegmentFinalId:1042,
			norcSegmentId:15, 
			primarySamplingUnitId:'156165615615', 
			primarySamplingUnitName:'',
			secondarySamplingUnitId:'', 
			secondarySamplingUnitName:'ffjadkfjldjfladjfldjflikjfldjfljdflijadlifjsdifjadfjdijflidjf;ljfdsijflijf;lsdjflaijfladijf;ladjf;dijflaidjf;laidjf;aidjf;aldijf',
			tertiarySamplingUnitId:'1835', 
			tertiarySamplingUnitName:'White Bear', 
			segmentId:6
		)

		assert !link.validate()
		assert "unique" == link.errors["westatSegmentFinalId"]
		assert "range" == link.errors["norcSegmentId"]
		assert "inList" == link.errors["primarySamplingUnitId"]
		assert "blank" == link.errors["secondarySamplingUnitId"]
		assert "maxSize" == link.errors["secondarySamplingUnitName"]
	}

}
