#!/usr/bin/env groovy

import com.sales_project.Docker

def call() {
    new Docker(this).dockerLogin()
}
