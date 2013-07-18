package com.kwedinger
import grails.converters.JSON

class PersonService {

    def getJSONData() {
        log.debug "Generating JSON for all persons"
        // collect method closure has it as default 1st parameter
        def persons = Person.list().collect {
            [
                    'id': it.id,
                    'firstName': it.firstName,
                    'lastName': it.lastName,
                    'age': it.age
            ]
        }
        // Map out the person JSON object
        def personOutput = [
                'success': true,
                'total': persons.size(),
                'persons': persons
        ] as JSON
        personOutput.prettyPrint = true
        return personOutput
    }
}
