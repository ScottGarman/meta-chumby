DESCRIPTION = "Chumby config block manager"
HOMEPAGE = "http://www.chumby.com/"
AUTHOR = "Henry Groover"
LICENSE = "GPLv2"
PR = "r0"

# No LICENSE related files are included:
LIC_FILES_CHKSUM = "file://Makefile;md5=55a241aebc975f6f29484fe6c7c20d02"

SRC_URI = "http://files.chumby.com/source/falconwing/build2370/utils-1.0.tgz"
S = "${WORKDIR}/utils-1.0"

do_compile() {
    ${CXX} ${CFLAGS} ${LDFLAGS} config_util.cpp -o config_util
}

do_install() {
    install -d ${D}/${bindir}
    install -m 0755 ${S}/config_util ${D}/${bindir}/config_util
}

SRC_URI[md5sum] = "72e935ae4eab40ffb50d9381578082eb"
SRC_URI[sha256sum] = "b231ab940c2f50fb7fef6b8bee8032b65eaa67f4b4bc7afd206455224721460f"
