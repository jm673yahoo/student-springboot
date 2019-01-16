# student-springboot
It is a simple service build by Springboot, JPA. There are two endpoints for now to access the student data.

_localhost:8080/students/2_

**Response:**

{
     "firstName": "VALAD",
     "lastName": "POOL",
     "dob": 19910304,
     "_links": {
         "self": {
             "href": "http://localhost:8080/students/2"
         },
         "students": {
             "href": "http://localhost:8080/students"
         }
     }
 }

_localhost:8080/students_

**Response:**
{
    "_embedded": {
        "students": [
            {
                "firstName": "MIKE",
                "lastName": "AJ",
                "dob": 19900320,
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/students/1"
                    },
                    "students": {
                        "href": "http://localhost:8080/students"
                    }
                }
            },
            {
                "firstName": "VALAD",
                "lastName": "POOL",
                "dob": 19910304,
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/students/2"
                    },
                    "students": {
                        "href": "http://localhost:8080/students"
                    }
                }
            }
        ]
    },
    "_links": {
        "self": {
            "href": "http://localhost:8080/students"
        }
    }
}
