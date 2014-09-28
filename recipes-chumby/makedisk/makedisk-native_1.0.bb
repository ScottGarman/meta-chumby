inherit native

DESCRIPTION = "Disk image creator"
HOMEPAGE = "http://www.chumby.com/"
AUTHOR = "Sean Cross"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=31e58b81f7cac0132ba619b1d0ffbe4a"

PR = "r1"

SRC_URI = "file://makedisk.c \
           file://LICENSE"

S = "${WORKDIR}"

do_compile() {
    ${CC} ${CFLAGS} ${LDFLAGS} makedisk.c -o makedisk
}

# Poky requires this, otherwise it flat-out fails to build
sstate_task_postfunc() {
    true
}

do_install() {
    install -d ${bindir}
    install -m 0755 ${S}/makedisk ${bindir}/makedisk
}
