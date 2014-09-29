DESCRIPTION = "Chumby boot blobs - miscellaneous binary blobs"
HOMEPAGE = "http://www.chumby.com/"
AUTHOR = "Sean Cross"
# All we have is a binary without sources. I'm suspicious this is
# really BSD licensed!
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3456d88788079e00bc8b13405a802849"

PROVIDES = "chumby-blobs"
COMPATIBLE_MACHINE = "chumby-silvermoon"

SRC_URI = "file://obm.bin \
           file://LICENSE"

S = "${WORKDIR}"

do_compile() {
    true
}

FILES_${PN} = "/boot"

do_install() {
    install -d ${D}/boot
    install -m 0755 ${S}/obm.bin ${D}/boot/obm.bin
}

do_runstrip() {
    true
}

# Copy the resulting file to the image directory
do_deploy() {
    install -d ${DEPLOY_DIR_IMAGE}
    install ${S}/obm.bin ${DEPLOY_DIR_IMAGE}/obm.bin
    package_stagefile_shell ${DEPLOY_DIR_IMAGE}/obm.bin
}
do_deploy[dirs] = "${S}"
addtask deploy before do_package_stage after do_compile
