package com.kwedinger



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Person)
class PersonTests {
    void testCreate() {
        def person = new Person( firstName: "Rob", lastName: "Smith", age: 40 )
        person.save()
        def persons = Person.list()
        assert persons.size() == 1
        def savedPerson = Person.findByFirstName( "Rob" )
        assertNotNull( savedPerson )
        assertEquals( savedPerson.lastName, "Smith" )
    }
}
