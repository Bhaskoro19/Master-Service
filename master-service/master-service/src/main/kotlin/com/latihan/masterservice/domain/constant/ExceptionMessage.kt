package com.latihan.masterservice.domain.constant

class ExceptionMessage {

    companion object {

        /**
         * MISSING
         */
        const val NAME_IS_MISSING :String = "Name is missing"
        const val ADDRESS_IS_MISSING :String = "Address is missing"
        const val SEARCH_FIELD_IS_MISSING :String = "Search field is missing"




        /**
         * DUPLICATE
         */



        /**
         * NOT VALID
         */
        const val MIN_REQUIRED_PAGE :String = "Minimum page is 1."

        const val USER_IS_NOT_CMS_USER : String = "User is not user CMS."

        const val USER_IS_NOT_MOBILE_USER : String = "User is not user Mobile."


        /**
         * NOT FOUND
         */

    }
}