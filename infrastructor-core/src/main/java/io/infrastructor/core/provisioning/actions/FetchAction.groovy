package io.infrastructor.core.provisioning.actions

import javax.validation.constraints.NotNull

class FetchAction {
    
    @NotNull
    def source
    @NotNull
    def target
    def user
    def sudopass

    def execute(def node) {
        new FileOutputStream(target).withCloseable {
            node.readFile(source, it, user, sudopass)
        }
        node.lastResult
    }
}
